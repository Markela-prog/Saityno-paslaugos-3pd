package lt.viko.eif.emarkevicius.restcasino;

import lt.viko.eif.emarkevicius.casino.model.Player;
import org.springframework.stereotype.Repository;

import java.util.*;
/**
 * The PlayerRepository class is responsible for managing player data.
 * It provides methods for saving, retrieving, updating, and deleting player objects.
 */
@Repository
public class PlayerRepository {
    private List<Player> players = new ArrayList<>();
    private Integer nextId = 1;

    /**
     * Saves a player.
     *
     * @param player The player to save.
     * @return The saved player.
     */
    public Player save(Player player) {
        if (player.getId() == null) {
            player.setId(nextId++);
        }
        players.add(player);
        return player;
    }

    /**
     * Finds a player by ID.
     *
     * @param id The ID of the player to find.
     * @return The found player, or null if not found.
     */
    public Player findById(Integer id) {
        return players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves all players.
     *
     * @return The list of all players.
     */
    public List<Player> findAll() {
        return new ArrayList<>(players);
    }

    /**
     * Updates a player.
     *
     * @param id     The ID of the player to update.
     * @param player The updated player information.
     * @return The updated player, or null if the player is not found.
     */
    public Player update(Integer id, Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(id)) {
                players.set(i, player);
                return player;
            }
        }
        return null;
    }

    /**
     * Deletes a player by ID.
     *
     * @param id The ID of the player to delete.
     * @return True if the player is deleted, false otherwise.
     */
    public boolean deleteById(Integer id) {
        return players.removeIf(player -> player.getId().equals(id));
    }
}

