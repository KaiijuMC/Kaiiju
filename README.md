
<div align="center">
  <img src="https://github.com/kugge/Kaiiju/blob/ver/1.19.3/logo.png?" width="32%" height="32%"/>
  <h1>Kaiiju</h1>
  <h3>Folia fork, designed for vanilla/anarchy servers</h3>

  [![License](https://img.shields.io/github/license/kugge/Kaiiju?style=for-the-badge&logo=github)](LICENSE)
  [![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/kugge/Kaiiju/build.yml?style=for-the-badge)](https://github.com/kugge/Kaiiju/actions)
  [![Discord](https://img.shields.io/discord/1059774886672859136?color=5865F2&label=discord&style=for-the-badge)](https://discord.gg/qagZRAepb7)

</div>

## Features

### Additions
- **Xymb Linear Format**: Saves about 50% of disk space in OW and Nether and 95% in The End.
- **Auto update**: Update upstream everyday.

### Roadmap
- **Static view distance**: Reduce RAM usage with a "cached" view distance.
- **Native world conversion**: Convert region file format at startup

## Configuration 
```bash
verbose: false
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
      format: ANVIL
      linear:
        compression-level: 1
    gameplay:
      shulker-box-drop-contents-when-destroyed: true
config-version: 1
```
- **format:** ANVIL, LINEAR
- **compression-level:** If you are using .linear the recommended value is 6.

## Building 
```bash
./gradlew applyPatches # Apply Kaiiju patches
./gradlew createReobfPaperclipJar # Generate Paperclip executable jar
```

## License
Original patches are licensed under GPL-3.0.

Made with <span style="color: #e25555;">&#9829;</span> on Earth.
