##Reload Permissions##
==================
---
Description
-----------
Have you tried to reload the permissions.yml fine within the Bukkit root folder? Unfortunately due to the way Bukkit's written, the only way to do this **SO FAR** was to /reload the whole server or restart it.

We all know reloading can cause problems, and a ton of them. I made a plugin for the Minecraft Cloud Network that utilizes Reflection to reload permissions for the Server.

This plugin is especially helpful for servers who want to use SQL based permission systems ([zPerms][1]) but have different permissions for each server, they can use permissions.yml to create their own custom permission strings for each server.
For example:
>ServerA has permission essentials.pay
ServerB has permission essentials.tpa
These permissions must be seperate for each server, make a permission string in permissions.yml of ServerA called
my.custom.permission.servera and add essentials.pay as a child node.
Do the same for ServerB and add essentials.tpa as a child node.
Add a global permission called my.custom.permission.servera/serverb and watch the magic happen :)

Also many thanks to [Me4502][2] for helping me with development of this plugin!

Note: This plugin will not go on Bukkit, why? Cause Bukkit really doesn't know how to respect the community. ([Yes I was banned for forgetting to change the text of a placeholder.][3])

Usage
-----
Currently there are no permissions to the main and only command of this plugin, I'm not sure if permissions would even work... So for now you **NEED** to be OP to be able to run the command, or just do it via console.

Commands
--------
/reloadperms - Basically reloads the permissions from permissions.yml

Future Versions
---------------
I don't currently have anything in mind for the future of this plugin, however I'll try to keep it updated with the ever changing Bukkit source.

Source Code
-----------
[![Source Code][4]][5]

Donate
-----
If you like what I'm doing please donate [here][6].


  [1]: http://dev.bukkit.org/bukkit-plugins/zpermissions/
  [2]: http://dev.bukkit.org/profiles/Me4502
  [3]: https://github.com/aaomidi/GUIShop/commit/85d8ca9522da447cd490a4fd58b6bbe1f5b380ee
  [4]: http://www.wtfpl.net/wp-content/uploads/2012/12/wtfpl-badge-1.png
  [5]: https://github.com/aaomidi/ReloadPermissions
  [6]: http://store.mccn.co/