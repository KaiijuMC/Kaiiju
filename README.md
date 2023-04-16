
<div align="center">
  <img src="https://github.com/kugge/Kaiiju/blob/ver/1.19.3/logo.png?" width="32%" height="32%"/>
  <h1>Kaiiju</h1>
  <h3>Folia fork, designed for vanilla/anarchy servers</h3>

  [![License](https://img.shields.io/github/license/kugge/Kaiiju?style=for-the-badge&logo=github)](LICENSE)
  [![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/kugge/Kaiiju/build.yml?style=for-the-badge)](https://github.com/kugge/Kaiiju/actions)
  [![Discord](https://img.shields.io/discord/1059774886672859136?color=5865F2&label=discord&style=for-the-badge)](https://discord.gg/qagZRAepb7)

</div>

## Features

### Configuration

```yaml
region-format:
  debug: false
network:
  send-null-entity-packets: true
  alternate-keepalive: false
gameplay:
  server-mod-name: Kaiiju
world-settings:
  default:
    region-format:
      format: LINEAR
      linear:
        compression-level: 1
        crash-on-broken-symlink: true
    gameplay:
      shulker-box-drop-contents-when-destroyed: true
```

### Roadmap
- **Static view distance**: Reduce RAM usage / Region size with a "static" view distance.
- **Hash linear**: Add chunk hashes to linear region files.
- **Native world conversion**: Convert region file format at startup.

## Building

```bash
./gradlew applyPatches # Apply Kaiiju patches
./gradlew createReobfPaperclipJar # Generate Paperclip executable jar
```

## License
Original patches are licensed under GPL-3.0.
