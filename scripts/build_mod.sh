#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT_DIR"

# Prefer caller-provided JAVA_HOME (e.g. GitHub Actions setup-java).
# If current java is not 17, fallback to a known local Java 17 path when available.
CURRENT_JAVA_MAJOR="$(java -version 2>&1 | awk -F '[".]' '/version/ {print $2; exit}')"
if [[ "$CURRENT_JAVA_MAJOR" != "17" && -x "$HOME/.local/share/mise/installs/java/17.0.2/bin/java" ]]; then
  export JAVA_HOME="$HOME/.local/share/mise/installs/java/17.0.2"
  export PATH="$JAVA_HOME/bin:$PATH"
fi

JAVA_MAJOR="$(java -version 2>&1 | awk -F '[".]' '/version/ {print $2; exit}')"
echo "Using java: $(java -version 2>&1 | head -n1)"
GRADLE_VERSION="$(gradle --version 2>/dev/null | awk '/Gradle / {print $2; exit}')"
echo "Using gradle: ${GRADLE_VERSION:-unknown}"
if [[ -n "${GRADLE_VERSION:-}" ]]; then
  GRADLE_MAJOR="${GRADLE_VERSION%%.*}"
  if [[ "$GRADLE_MAJOR" -lt 7 ]]; then
    echo "ERROR: Gradle 7.4+ required. Found $GRADLE_VERSION"
    exit 3
  fi
  if [[ "$GRADLE_MAJOR" -ge 9 ]]; then
    echo "ERROR: ForgeGradle for this project does not support Gradle $GRADLE_VERSION yet."
    echo "Use Gradle 8.x (recommended: 8.14.3)."
    exit 4
  fi
fi

if [[ "$JAVA_MAJOR" != "17" ]]; then
  echo "WARNING: Expected Java 17 for this 1.20.1 Forge project, found Java $JAVA_MAJOR"
fi

GRADLE_ARGS=(clean build --stacktrace)
if [[ "${REFRESH_DEPS:-0}" == "1" ]]; then
  GRADLE_ARGS+=(--refresh-dependencies)
fi

# Pass through extra CLI args for debugging (e.g. --info, --scan)
if [[ "$#" -gt 0 ]]; then
  GRADLE_ARGS+=("$@")
fi

echo "Running: gradle ${GRADLE_ARGS[*]}"
if ! gradle "${GRADLE_ARGS[@]}"; then
  echo
  echo "Build failed. Common causes:"
  echo "  1) Cannot reach Forge Maven: https://maven.minecraftforge.net/"
  echo "  2) Missing Java 17 runtime or incorrect JAVA_HOME"
  echo "  3) Corrupt Gradle cache (try: REFRESH_DEPS=1 ./scripts/build_mod.sh)"
  echo "  4) Dependency/version mismatch in build.gradle or gradle.properties"
  exit 1
fi

echo
if compgen -G "build/libs/*.jar" > /dev/null; then
  echo "Build complete. Jars in build/libs/:"
  ls -1 build/libs/*.jar
else
  echo "Build completed but no jars were found in build/libs/."
  echo "Check Gradle output for disabled jar task or packaging errors."
  exit 2
fi
