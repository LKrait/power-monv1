# Factory Feeder Monitor
Modern industrial dark-theme Android app for monitoring 12 factory main feeders. Targets Android 16 / API 36 and is suitable for a Samsung A17-class device.

## Included screens
- Dashboard: total demand, online/alarm counts, overall PF and energy
- Feeders: 12 cards with kW, voltage, current, PF, kWh and state
- Alarms: active feeder warnings
- Trends: lightweight demand history bars generated on-device
- Settings: demo/live API switch, endpoint status and refresh information

## GitHub build
Upload the contents of this project to a GitHub repository. Open **Actions**, run **Build Android APK**, and download `FactoryFeederMonitor-debug-apk`.

## Django connection
Change `FEEDER_API_URL` in `app/build.gradle.kts`. The app expects HTTPS JSON:
```json
{"timestamp":"2026-10-09T13:20:00Z","feeders":[{"id":1,"name":"Noodle Line 1","status":"NORMAL","kw":312.4,"voltage":415.2,"current":438.0,"power_factor":0.96,"energy_kwh":5421.0}]}
```
Provide 12 objects in `feeders`. Supported states are `NORMAL`, `WARNING`, `ALARM`, and `OFFLINE`. If the API is unavailable or malformed, the app uses demo data and identifies it as a fallback.

## OT security
Do not expose meters, drives, PLCs or the OT network directly to the internet. Put Django behind HTTPS and authentication, authorize users server-side, expire tokens, rate-limit requests, log access, and expose only required read-only data.
