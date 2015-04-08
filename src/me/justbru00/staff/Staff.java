package me.justbru00.staff;

import java.util.logging.Logger;

import me.justbru00.staff.api.JustAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Staff extends JavaPlugin implements Listener {

	Logger logger = Logger.getLogger("Minecraft");
	
	private JustAPI api = new JustAPI();

	public String dnJustBru00 = "&8[&b&lOwner&8] &6JustBru00";
	public String dnComputerdude3 = "&8[&bCo-Owner&8] &6Computerdude3";
	public String dn_BlazeCraft = "&8[&4Head-Admin&8] &6_BlazeCraft";
	public String dnVhirus = "&8[&4Admin&8] &6Vhirus";
	public String dnFireShadow196 = "&8[&bCo-Owner&8] &6FireShadow196";
	public String dngoldbrother = "&8[&bCo-Owner&8] &6goldbrother";	
	public String dntruejedity = "&8[&5MOD&8] &6truejedity";
	public String guiName = "&b&l&nStaff";
	

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("staff")) {
			player.sendMessage(ChatColor.GREEN + "Opening GUI.");			
			openGUI(player);
		}
		if (commandLabel.equalsIgnoreCase("staffonline")) {
		 player.sendMessage(ChatColor.RED + "This Is Not Ready Yet.");		
		}

		return false;
	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled.");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version: "
				+ pdfFile.getVersion() + " Has Been Enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}

	public Inventory inv;
	

	public void openGUI(Player player) {
		inv = Bukkit.createInventory(null, 9, api.color(guiName));
/**
*		
*		 0  1  2  3  4  5  6  7  8
*		 9 10 11 12 13 14 15 16 17 
*	
*		0=JustBru00
*		1=Computerdude3
*		2=FireShadow196
*		3=goldbrother
*		4=_BlazeCraft
*		5=Vhirus
*		
*		7=truejedity
*		8=close button
*
**/		
		
		// JustBru00		
		inv.setItem(0, api.createSkullwithLore(dnJustBru00, "JustBru00", "&eAlso a &8[&5DEV&8]"));
		// Computerdude3		
		inv.setItem(1, api.createSkullwithLore(dnComputerdude3, "Computerdude3", "&eAlso a &8[&1Builder&8]"));
		//FireShadow196
		inv.setItem(2, api.createSkullwithLore(dnFireShadow196, "FireShadow196", "&eAlso a &8[&1Head-Builder&8]"));
		//goldbrother
		inv.setItem(3, api.createSkullwithLore(dngoldbrother, "goldbrother", "&eAlso a &8[&cPvP&5MOD&8]"));		
		// _BlazeCraft		
		inv.setItem(4, api.createSkullwithLore(dn_BlazeCraft, "_BlazeCraft", "&eAlso a &8[&1Builder&8]"));
		//Vhirus
		inv.setItem(5, api.createSkullwithLore(dnVhirus, "Vhirus", "&eHas been with the server a long time."));
		//agent_scout		
		//truejedity
		inv.setItem(6, api.createSkullwithLore(dntruejedity, "truejedity", "&eOne of our newest staff!"));		
		// Close Barrier
		ItemStack Close = new ItemStack(Material.BARRIER);
		ItemMeta closemeta = Close.getItemMeta();
		closemeta.setDisplayName(ChatColor.DARK_RED + "Close");
		Close.setItemMeta(closemeta);
		inv.setItem(8, Close);

		player.openInventory(inv);
	}

	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().contains(api.color(guiName))) {
			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getSlot() >= -1 && e.getSlot() != 8) {
				p.chat("/msg " + p.getName() + " Please use /helpop to get help from staff.");
			}
			else if (e.getCurrentItem().getType() == Material.BARRIER) {
				p.sendMessage(ChatColor.RED + "Closed GUI.");
				p.closeInventory();
			}
			
		}

	}
}
