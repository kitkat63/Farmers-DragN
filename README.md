# Farmer's DragN

A Forge 1.20.1 compatibility mod that bridges Farmer's Delight with DragN's Overhauled Livestock and Pets, while leaving room for optional food-mod compat such as Hearth and Harvest and Brewin' and Chewin'.

## Creator

- **KitKat** — creator of Farmer's DragN.

## Credits

- **Vector Wing** — creator of **Farmer's Delight**.
- **DragN0007** — creator of **Overhauled Livestock** and **Overhauled Pets**.

## Starter structure

- `src/main/java/com/farmersdragn/farmersdragn/` contains the main mod bootstrap and compat module declarations.
- `src/main/resources/META-INF/mods.toml` declares the mod metadata, required core dependencies, and optional add-on ordering.
- `src/main/resources/assets/farmersdragn/` contains player-facing assets such as lang entries and future models/textures.
- `src/main/resources/data/farmersdragn/tags/items/` contains shared compat tags for whole and cut cheeses.
- `src/generated/resources/` is reserved for future datagen output.


## Troubleshooting: items not appearing

If the game boots but Farmer's DragN items are not visible, check these first:

1. **Creative tabs**: items now show in both the dedicated **Farmer's DragN** tab and vanilla **Food & Drinks**.
2. **Required dependencies**: this mod requires **Farmer's Delight**, **DragN's Overhauled Livestock**, and **DragN's Overhauled Pets** for Minecraft 1.20.1.
3. **Version match**: use Forge 47.x on Minecraft 1.20.1 with matching mod versions.
4. **Log validation**: check `latest.log` for the mod id `farmersdragn` and item registration errors.
5. **Recipe unlocks**: Farmer's DragN now grants all its recipes on player tick so Survival/Adventure players can craft without waiting for individual unlock triggers.


## Rebuild from project root (recommended)

Use Java 17 and Gradle 7.4+ (8.x recommended) directly from the repo root:

```bash
cd /path/to/Farmer-s-DragN2
export JAVA_HOME=/path/to/jdk-17
export PATH="$JAVA_HOME/bin:$PATH"
gradle clean build
```

Or run the helper:

```bash
./scripts/build_mod.sh
```

Then copy the jar from `build/libs/` into your game `mods/` folder.

If `build/libs/` is missing, use `./scripts/build_mod.sh` — it runs with `--stacktrace` by default, fails fast with specific causes, and verifies the jar output path.

If dependency downloads look stale/corrupt, retry with:

```bash
REFRESH_DEPS=1 ./scripts/build_mod.sh --info
```

If Gradle cannot resolve `net.minecraftforge.gradle:ForgeGradle`, verify network access to `https://maven.minecraftforge.net/` and keep the repositories in `settings.gradle` unchanged.


### Java runtime note

This repo intentionally does **not** hardcode `org.gradle.java.home` because absolute paths break on other machines/CI.
Use `JAVA_HOME` (or GitHub Actions `setup-java`) to provide Java 17 at build time.


## Alternative for Windows Java conflicts: build on GitHub Actions

If local Java version switching is stuck (for example Windows keeps using Java 21), use the included GitHub Actions workflow to build with Java 17 in the cloud:

1. Push your branch to GitHub.
2. Open **Actions** tab in your repository.
3. Click a specific workflow run (not the settings sidebar).
4. In that run's **Summary** page, scroll to the **Artifacts** panel on the right.
5. Download **`farmersdragn-build-libs`** on success, or **`farmersdragn-build-log`** on failure.
6. Put the downloaded jar from the artifact into your Minecraft `mods/` folder.

This bypasses local Java/PATH issues entirely.


### If the GitHub Action exits with code 1

Open the failed run and check **Environment diagnostics** output first. Also download **`farmersdragn-build-log`** artifact for the full Gradle output.

The workflow also strips any `org.gradle.java.home` line from `gradle.properties` at runtime so old machine-specific paths do not break CI.
If either Forge Maven endpoint fails, the run cannot download ForgeGradle:

- `https://maven.minecraftforge.net/`
- `https://files.minecraftforge.net/maven`

Re-run after network/repository recovery, or trigger workflow again from Actions once endpoints are reachable.

The workflow now uses the runner's system Gradle directly (after Java 17 setup) to avoid `setup-gradle` post-step exit-code failures.
