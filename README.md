# Protect

A lightweight modern alternative to WorldGuard optimized for API usage

* [Commands](#commands)
* [Area flags](#area-flags)
* [Permission Packs](#permission-packs)
* [API](#api)

BStats can be found [here](https://bstats.org/plugin/bukkit/TheNextLvl%2520Protect/21712)

## Commands

| Command                                  | Description                                       | Permission                            |
|------------------------------------------|---------------------------------------------------|---------------------------------------|
| `/area create <name> [<priority>]`       | create new areas                                  | protect.command.area.create           |
| `/area delete <area>`                    | delete existing areas                             | protect.command.area.delete           |
| `/area flag info [flag] (area)`          | query information about area flags                | protect.command.area.flag.info        |
| `/area flag list [<provider>]`           | list all existing area flags                      | protect.command.area.flag.list        |
| `/area flag reset <flag> [<area>]`       | reset specified flags of areas                    | protect.command.area.flag.reset       |
| `/area flag set <flag> <value> [<area>]` | change specified flags of areas                   | protect.command.area.flag.set         |
| `/area group add <group> [<name>]`       | add your current selection to a group             | protect.command.area.group.add        |
| `/area group create <area>`              | create a group from an area                       | protect.command.area.group.create     |
| `/area group delete <group>`             | delete a group (does not delete the area)         | protect.command.area.group.delete     |
| `/area group list [<group>]`             | list all groups or regions of a group             | protect.command.area.group.list       |
| `/area group redefine <group> <region>`  | redefine a region inside a group                  | protect.command.area.group.redefine   |
| `/area group remove <group> <region>`    | remove a region from a group                      | protect.command.area.group.remove     |
| `/area group select <group> <region>`    | select a region inside a group                    | worldedit.selection.pos               |
| `/area info [<area>]`                    | query information about specific areas            | protect.command.area.info             |
| `/area list`                             | list all areas                                    | protect.command.area.list             |
| `/area members add <area> <players>`     | add members to an area                            | protect.command.area.members.add      |
| `/area members list [<area>]`            | list all members of an area                       | protect.command.area.members.list     |
| `/area members remove <player>`          | remove a member from an area                      | protect.command.area.members.remove   |
| `/area owner remove <player>`            | remove the owner of an area                       | protect.command.area.owner.remove     |
| `/area owner set <area> <player>`        | set the owner of an area                          | protect.command.area.owner.set        |
| `/area parent remove <area>`             | remove the parent of an area                      | protect.command.area.parent.remove    |
| `/area parent set <area> <parent>`       | set the parent of an area                         | protect.command.area.parent.set       |
| `/area priority <area> [<priority>]`     | view or change the priority of areas              | protect.command.area.priority         |
| `/area protect <area> [remove]`          | add, update or remove the protection of an area   | protect.command.area.protect          |
| `/area redefine <area>`                  | redefine the region of an existing area           | protect.command.area.redefine         |
| `/area schematic delete <area>`          | delete an area's schematic                        | protect.command.area.schematic.delete |
| `/area schematic load <area>`            | load in an area's schematic                       | protect.command.area.schematic.load   |
| `/area schematic save <area>`            | save an area's schematic                          | protect.command.area.schematic.save   |
| `/area select <area>`                    | (worldedit) select the region of an existing area | worldedit.selection.pos               |
| `/area teleport <area>`                  | teleport yourself to an area                      | protect.command.area.teleport         |

## Area flags

| Flag                        | Description                                   | Value              |
|-----------------------------|-----------------------------------------------|--------------------|
| protect:farewell            | message that is send when leaving an area     | MiniMessage String |
| protect:farewell_actionbar  | actionbar that is shown when leaving an area  | MiniMessage String |
| protect:farewell_title      | title that is send when leaving an area       | MiniMessage String |
| protect:greetings           | message that is send when entering an area    | MiniMessage String |
| protect:greetings_actionbar | actionbar that is shown when entering an area | MiniMessage String |
| protect:greetings_title     | title that is send when entering an area      | MiniMessage String |
| protect:time                | change the time inside of an area             | Integer            |
| protect:weather             | change the weather inside of an area          | DOWNFALL / CLEAR   |

### Boolean Flags

| Flag                               | Description                                                        | 
|------------------------------------|--------------------------------------------------------------------|
| protect:enter                      | allows or denies entrance                                          | 
| protect:leave                      | allows or denies exit                                              |
| protect:damage                     | controls whether damage can be applied                             |
| protect:entity_item_drop           | controls whether entities can drop items                           |
| protect:entity_item_pickup         | controls whether entities can pickup items                         |
| protect:game_events                | controls whether sculk sensors can pick up on game events (sounds) |
| protect:gravity                    | enables or disables gravity                                        |
| protect:hunger                     | controls whether hunger is applied                                 |
| protect:liquid_flow                | enables or disables liquid flow                                    |
| protect:natural_entity_spawn       | controls whether entities can naturally spawn                      |
| protect:notify_failed_interactions | enables or disables failed-interaction messages                    |
| protect:physics                    | enables or disables physics                                        |
| protect:redstone                   | enables or disables redstone                                       |

### Protection Flags

| Flag                                  | Description                                                                                            |
|---------------------------------------|--------------------------------------------------------------------------------------------------------|
| protect:armor_stand_manipulate        | allows or denies armor stand manipulations                                                             |
| protect:armor_washing                 | allows or denies washing off the color of armor<br/>(in cauldrons)                                     |
| protect:banner_washing                | allows or denies washing off the color of banners<br/>(in cauldrons)                                   |
| protect:block_absorb                  | controls whether sponges can absorb water                                                              |
| protect:block_break                   | allows or denies block breaking                                                                        |
| protect:block_burning                 | controls whether blocks can burn                                                                       |
| protect:block_drying                  | controls whether blocks can dry out<br/>(farmland)                                                     |
| protect:block_fading                  | controls whether blocks can fade away<br/>(like ice or snow melting or corals fading)                  |
| protect:block_fertilize               | controls whether blocks can be fertilized                                                              |
| protect:block_forming                 | controls whether blocks can randomly form<br/>(like snow from a snow storm or ice in cold environment) |
| protect:block_growth                  | controls whether blocks can grow<br/>(like wheat or carrots)                                           |
| protect:block_igniting                | controls whether blocks can ignite<br/>(like fire spreading or lightning striking)                     |
| protect:block_moisturising            | controls whether blocks can moisturise<br/>(farmland)                                                  |
| protect:block_place                   | allows or denies block placing                                                                         |
| protect:block_spread                  | controls whether blocks can spread<br/>(like grass or fire)                                            |
| protect:cauldron_evaporation          | controls whether cauldrons can evaporate from biome dryness                                            |
| protect:cauldron_extinguish_entity    | controls whether cauldrons can extinguish flaming entities                                             |
| protect:cauldron_level_change_unknown | controls whether cauldrons can change their level for unknown reasons                                  |
| protect:crop_trample                  | allows or denies crop trampling                                                                        |
| protect:empty_bottle                  | allows or denies emptying a bottle                                                                     |
| protect:empty_bucket                  | allows or denies emptying a bucket                                                                     |
| protect:entity_attack_entity          | controls whether entities can attack other entities                                                    |
| protect:entity_attack_player          | controls whether entities can attack players                                                           |
| protect:entity_interact               | allows or denies interaction with entities<br/>(like trading with merchants)                           |
| protect:entity_place                  | allows or denies placing entities<br/>(like boats or minecarts)                                        |
| protect:entity_shear                  | allows or denies shearing entities<br/>(like sheep or snow golems)                                     |
| protect:explosions                    | controls whether explosions can do block damage                                                        |
| protect:fill_bottle                   | allows or denies filling a bottle                                                                      |
| protect:fill_bucket                   | allows or denies filling a bucket                                                                      |
| protect:interact                      | allows or denies block interactions<br/>(like opening chests or doors)                                 |
| protect:leaves_decay                  | controls whether leaves can decay                                                                      |
| protect:natural_cauldron_fill         | controls whether cauldrons can fill naturally<br/>(from rain)                                          |
| protect:physical_interact             | allows or denies physical interactions<br/>(like standing on pressure plates or drip leaves)           |
| protect:player_attack_entity          | controls whether players can attack entities                                                           |
| protect:player_attack_player          | controls whether players can attack players                                                            |
| protect:player_item_drop              | controls whether players can drop items                                                                |
| protect:shulker_washing               | allows or denies washing off color the color of shulker chests<br/>(in cauldrons)                      |

## Permission Packs

Permission packs streamline server management by providing bundled options
instead of dealing with a multitude of individual permissions.

### protect.admin

Allows players to manage all areas and bypass all restrictions

    protect.command.area.create
    protect.command.area.delete
    protect.command.area.manage
    protect.bypass.admin

### protect.bypass.admin

Allows players to bypass any restriction

    protect.bypass.build
    protect.bypass.break
    protect.bypass.interact
    protect.bypass.physical-interact
    protect.bypass.entity-interact
    protect.bypass.trample
    protect.bypass.enter
    protect.bypass.leave
    protect.bypass.empty-bucket
    protect.bypass.fill-bucket
    protect.bypass.empty-bottle
    protect.bypass.fill-bottle
    protect.bypass.wash-banner
    protect.bypass.wash-shulker
    protect.bypass.wash-armor

### protect.command.area

Allows players to interact with areas in a non-destructive manner

    protect.command.area.flag.info
    protect.command.area.flag.list
    protect.command.area.info
    protect.command.area.list

### protect.command.area.flag

Allows players to manage area flags

    protect.command.area.flag.info
    protect.command.area.flag.list
    protect.command.area.flag.set
    protect.command.area.flag.reset

### protect.command.area.manage

Allows players to manage existing areas

    protect.command.area
    protect.command.area.flag
    protect.command.area.priority
    protect.command.area.redefine
    protect.command.area.schematic

### protect.command.area.schematic

Allows players to manage area schematics

    protect.command.area.schematic.delete
    protect.command.area.schematic.load
    protect.command.area.schematic.save

## API

https://repo.thenextlvl.net/#/releases/net/thenextlvl/protect/api
