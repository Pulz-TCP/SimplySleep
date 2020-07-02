# SimplySleep
 A simple sleep plugin that negates the need for sleep voting and allows players to decide whether to allow Phantom attacks.
 Built against Spigot API 1.15, tested on Paper 1.16.1

# Current Features: 
* /sleep : Resets player sleep statistics that are used to calculate Phantom spawning
* /sleeptime : Outputs current sleep statistics in minecraft ticks and converted into in-game days, hours, minutes and seconds.
* Interacting with a bed does the same as /sleep if the permission is granted

# Permissions
| Command | Permission node | Feature |
| ------------- | ------------- | ------------- |
| /sleep | simplysleep.sleep | Resets user sleep time | 
| /sleeptime | simplysleep.sleeptime | Checks time since last 'sleep' | 
| N/A | simplysleep.oninteract | Enables /sleep to run when interacting with a bed (regardless of time) |

# Planned Features: 
* ~~Improve statistics, need to calculate days since sleep~~ Done!
* Command to immediately enable Phantom Spawn
* Configurable time to check a player's rest time, for toggleable warning when player exceeds 3 days without sleep (Phantoms spawn)
