
<div align="center">
  <img src="https://github.com/kugge/Kaiiju/blob/ver/1.19.3/logo.png?" width="32%" height="32%"/>
  <h1>Kaiiju</h1>
  <h3>Folia fork, designed for vanilla/anarchy servers</h3>

  [![License](https://img.shields.io/github/license/kugge/Kaiiju?style=for-the-badge&logo=github)](LICENSE)
  [![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/kugge/Kaiiju/build.yml?style=for-the-badge)](https://github.com/kugge/Kaiiju/actions)
  [![Discord](https://img.shields.io/discord/1059774886672859136?color=5865F2&label=discord&style=for-the-badge)](https://discord.gg/qagZRAepb7)

</div>

## Features

### Primary
- **Xymb Linear Format**: Saves about 50% of disk space in OW/Nether and 95% in The End.
- **Auto update**: Automatic upstream updates.

### Notable
- **Optimize Hopper**: Enable/Disable Paper "Optimize Hopper" patch that break a lot of redstone farms.
- **Fix void trading**: Enable/Disable void trading.

### Configuration

```yaml
verbose: false
gameplay:
  server-mod-name: Kaiiju
network:
  send-null-entity-packets: true
  alternate-keepalive: false
region-format:
  debug: false
world-settings:
  default:
    gameplay:
      shulker-box-drop-contents-when-destroyed: true
      fix-void-trading: true
      optimize-hoppers: true
      tick-when-empty: true
    region-format:
      format: ANVIL
      linear:
        compression-level: 1
        crash-on-broken-symlink: true
config-version: 1
```
Documentation: [Kaiiju Wiki](https://github.com/KaiijuMC/Kaiiju/wiki/Configuration)

### Roadmap
- **Static view distance**: Reduce RAM usage / Region size with a "static" view distance.
- **Native world conversion**: Convert region file format at startup.
- **Stash deduplication**: Make giant dupe stashes possible and lagless.

## Building

```bash
./gradlew applyPatches # Apply Kaiiju patches
./gradlew createReobfPaperclipJar # Generate Paperclip executable jar
```

## License
Original patches are licensed under GPL-3.0.
