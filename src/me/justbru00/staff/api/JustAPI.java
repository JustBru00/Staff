package me.justbru00.staff.api;

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
		sm.setDisplayName(noncoloredDisplayName);
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
