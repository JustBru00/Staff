package justbru00.staff;

import java.util.logging.Logger;

import net.minecraft.server.v1_8_R1.ScoreboardObjective;

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
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Staff extends JavaPlugin implements Listener {

	Logger logger = Logger.getLogger("Minecraft");

	public String dnJustBru00 = "&8[&b&lOwner&8] &6JustBru00";
	public String dnComputerdude3 = "&8[&bCo-Owner&8] &6Computerdude3";
	public String dn_BlazeCraft = "&8[&4Head-Admin&8] &6_BlazeCraft";

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

	public void openGUI(Player player) {
		inv = Bukkit.createInventory(null, 18, ChatColor.AQUA + "Staff");

		// JustBru00
		ItemStack JustBru00 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta skullmetaJustBru00 = (SkullMeta) JustBru00.getItemMeta();
		skullmetaJustBru00.setDisplayName(color(dnJustBru00));
		skullmetaJustBru00.setOwner("JustBru00");
		JustBru00.setItemMeta(skullmetaJustBru00);
		inv.setItem(0, JustBru00);

		// Computerdude3
		ItemStack Computerdude3 = new ItemStack(Material.SKULL_ITEM, 1,
				(short) 3);
		SkullMeta skullmetaComputerdude3 = (SkullMeta) Computerdude3
				.getItemMeta();
		skullmetaComputerdude3.setDisplayName(color(dnComputerdude3));
		skullmetaComputerdude3.setOwner("Computerdude3");
		Computerdude3.setItemMeta(skullmetaComputerdude3);
		inv.setItem(1, Computerdude3);
		
		// _BlazeCraft
		ItemStack _BlazeCraft = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sk_BlazeCraft = (SkullMeta) _BlazeCraft.getItemMeta();
		sk_BlazeCraft.setDisplayName(color(dn_BlazeCraft));
		sk_BlazeCraft.setOwner("_BlazeCraft");
		_BlazeCraft.setItemMeta(sk_BlazeCraft);
		inv.setItem(2, _BlazeCraft);

		// Close Barrier
		ItemStack Close = new ItemStack(Material.BARRIER);
		ItemMeta closemeta = Close.getItemMeta();
		closemeta.setDisplayName(ChatColor.DARK_RED + "Close");
		Close.setItemMeta(closemeta);
		inv.setItem(17, Close);

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
