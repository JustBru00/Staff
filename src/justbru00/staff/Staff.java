package justbru00.staff;

import java.util.logging.Logger;
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
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Staff extends JavaPlugin implements Listener {

	Logger logger = Logger.getLogger("Minecraft");

	public String dnJustBru00 = "&8[&b&lOwner&8] &6JustBru00";
	public String dnComputerdude3 = "&8[&bCo-Owner&8] &6Computerdude3";
	public String dn_BlazeCraft = "&8[&4Head-Admin&8] &6_BlazeCraft";
	public String dnVhirus = "&8[&4Admin&8] &6Vhirus";
	public String dnFireShadow196 = "&8[&bCo-Owner&8] &6FireShadow196";
	public String dngoldbrother = "&8[&bCo-Owner&8] &6goldbrother";
	public String dnagent_scout = "&8[&5MOD&8] &6agent_scout";
	public String dntruejedity = "&8[&5MOD&8] &6truejedity";

	public String color(String uncolored) {
		String colored = ChatColor.translateAlternateColorCodes('&', uncolored);
		return colored;
	}

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
	
	public ItemStack skull(String displayName, String owner) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();
		sm.setOwner(owner);
		sm.setDisplayName(color(displayName));
		is.setItemMeta(sm);		
		return is;
		}

	public void openGUI(Player player) {
		inv = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Staff");
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
*		6=agent_scout
*		7=truejedity
*		8=close button
*
**/		
		
		// JustBru00		
		inv.setItem(0, skull(dnJustBru00, "JustBru00"));
		// Computerdude3		
		inv.setItem(1, skull(dnComputerdude3, "Computerdude3"));
		//FireShadow196
		inv.setItem(2, skull(dnFireShadow196, "FireShadow196"));
		//goldbrother
		inv.setItem(3, skull(dngoldbrother, "goldbrother"));		
		// _BlazeCraft		
		inv.setItem(4, skull(dn_BlazeCraft, "_BlazeCraft"));
		//Vhirus
		inv.setItem(5, skull(dnVhirus, "Vhirus"));
		//agent_scout
		inv.setItem(6, skull(dnagent_scout, "agent_scout"));
		//truejedity
		inv.setItem(7, skull(dntruejedity, "truejedity"));		
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

		if (e.getInventory().getTitle().contains(ChatColor.AQUA + "Staff")) {
			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;

			} else if (e.getCurrentItem().getType() == Material.BARRIER) {

				p.sendMessage(ChatColor.RED + "Closed GUI.");
				p.closeInventory();

			}
		}

	}
}
