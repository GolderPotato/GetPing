package Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	@Override
	public void onEnable() {
		System.out.println("Le plugin getPing est activé OMAGAD");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("ping")){
			if(args.length == 0){
				try{
				int ping =((CraftPlayer)p).getHandle().ping;
				p.sendMessage("Votre ping est de: "+ping+"ms!");
				}catch(Exception e){
					p.sendMessage("§4Une érreur s'est produite!");
				}
				
			}else{
				try{
					for(Player pls : Bukkit.getServer().getOnlinePlayers()){
						if(pls.getName().toString().equalsIgnoreCase(args[0])){
							int ping =((CraftPlayer)pls).getHandle().ping;
							p.sendMessage("Le ping de"+pls+" est de: "+ping+"ms!");
						}
					}
				}catch(Exception e){
					p.sendMessage("§4Ce joueur n'est pas connecté!");
				}
			}
		}
		return false;
	}
}
