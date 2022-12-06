package me.neoblade298.neosessions.sessions;

import java.util.HashMap;

import org.bukkit.configuration.ConfigurationSection;

public class DungeonSessionInfo extends SessionInfo {
	private HashMap<String, Integer> spawners = new HashMap<String, Integer>();
	
	public DungeonSessionInfo(ConfigurationSection cfg) {
		super(cfg);
		ConfigurationSection sec = cfg.getConfigurationSection("spawners");
		for (String spawner : sec.getKeys(false)) {
			spawners.put(spawner, sec.getInt(spawner));
		}
	}

	@Override
	public Session createSession(String from, int numPlayers, int multiplier) {
		return new DungeonSession(this, from, numPlayers, multiplier);
	}
	
	public HashMap<String, Integer> getSpawners() {
		return spawners;
	}
}
