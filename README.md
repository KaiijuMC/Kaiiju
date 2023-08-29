<div align="center">
  <img src="https://github.com/kugge/Kaiiju/blob/ver/1.19.3/logo.png?" width="32%" height="32%"/>
  <h1>Kaiiju</h1>
  <h3>Folia fork, designed for vanilla/anarchy servers</h3>

  [![License](https://img.shields.io/github/license/kugge/Kaiiju?style=for-the-badge&logo=github)](LICENSE)
  [![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/kugge/Kaiiju/build.yml?style=for-the-badge)](https://github.com/kugge/Kaiiju/actions)
  [![Discord](https://img.shields.io/discord/1059774886672859136?color=5865F2&label=discord&style=for-the-badge)](https://discord.gg/qagZRAepb7)

</div>

## Features

### Notable
- **Xymb Linear Format**: A Region file format that reduces disk space usage by about 50%.
- **Async Pathfinding**: Petal async pathfinding fixed & reworked.
- **Technical Minecraft**: Enable Vanilla exploits such as sand duping, RNG manipulation...

### Other
- **Small optimizations**: Increase server efficiency by disabling unnecessary features.
- **Commands**: Restore few commands that were previously removed by Folia.

### Configuration

```yaml
region-format:
  linear:
    flush-frequency: 10
    flush-max-threads: 1
network:
  send-null-entity-packets: true
  alternate-keepalive: false
  kick-player-on-bad-packet: true
optimization:
  disable-vanish-api: false
  disable-player-stats: false
  disable-arm-swing-event: false
  async-path-processing:
    enable: false
    max-threads: 0
    keepalive: 60
gameplay:
  server-mod-name: Kaiiju
  shared-random-for-players: true
unsupported:
  disable-ensure-tick-thread-checks: false
  global-event-synchronization: false
world-settings:
  default:
    region-format:
      format: ANVIL
      linear:
        compression-level: 1
        crash-on-broken-symlink: true
    optimization:
      shulker-box-drop-contents-when-destroyed: true
      optimize-hoppers: true
      tick-when-empty: true
      enable-entity-throttling: false
      disable-achievements: false
      disable-creatures-spawn-events: false
      disable-dolphin-swim-to-treasure: false
    gameplay:
      fix-void-trading: true
      break-redstone-on-top-of-trap-doors-early: true
      fix-tripwire-state-inconsistency: true
      safe-teleportation: true
      sand-duplication: false
      teleport-async-on-high-velocity: false
```
Documentation: [Kaiiju Wiki](https://github.com/KaiijuMC/Kaiiju/wiki/Configuration)

### Roadmap
- **Stash deduplication**: Make giant dupe stashes possible and lagless.
- **Multithreaded Tracker**: Rework Petal multithreaded tracker.

## Open to contributions
- **Native world conversion**: Convert region file format at startup.
- **Performance patch**: Any significative performance patch.

## Building

```bash
./gradlew applyPatches # Apply Kaiiju patches
./gradlew createReobfPaperclipJar # Generate Paperclip executable jar
```

## License
Original patches are licensed under GPL-3.0.
