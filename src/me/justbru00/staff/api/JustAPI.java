/**
*This API is for usage with plugins by Justin Brubaker and for usage by non-commercial open source projects.
*Contact Justin Brubaker @ justbru00@gmail.com for a usage consent for commerical projects.
*/
package me.justbru00.staff.api;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class JustAPI {

	public ItemStack createSkull(String owner, String noncoloredDisplayName) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		sm.setDisplayName(color(noncoloredDisplayName));
		is.setItemMeta(sm);		
		return is;		
	}
	
	public ItemStack createSkullwithLore(String noncoloredDisplayName, String owner, String lore) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(color(lore));
		sm.setDisplayName(color(noncoloredDisplayName));
		sm.setLore(reallore);
		is.setItemMeta(sm);		
		return is;		
	}
	
	public ItemStack renameDisplayName(ItemStack toRename, String Displayname) {
		ItemStack is = toRename;
		ItemMeta im = is.getItemMeta();	
		im.setDisplayName(color(Displayname));
		is.setItemMeta(im);		
		return is;
	}
	
	public String color(String uncolored) {
		String colored = ChatColor.translateAlternateColorCodes('&', uncolored);
	return colored;	
	}
}
