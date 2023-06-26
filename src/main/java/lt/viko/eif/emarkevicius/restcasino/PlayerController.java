package lt.viko.eif.emarkevicius.restcasino;

import lt.viko.eif.emarkevicius.casino.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The PlayerController class is a RESTful web service controller that handles player-related operations.
 * It provides endpoints for retrieving, creating, updating, and deleting players.
 */
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Retrieves a player by ID.
     *
     * @param id The ID of the player to retrieve.
     * @return The ResponseEntity containing the player if found, or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Integer id) {
        Player player = playerRepository.findById(id);

        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves all players.
     *
     * @return The list of all players.
     */
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Creates a new player.
     *
     * @param player The player to create.
     * @return The ResponseEntity containing the created player if successful, or a 500 Internal Server Error status if an error occurred.
     */
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player createdPlayer = playerRepository.save(player);

        if (createdPlayer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Updates an existing player.
     *
     * @param id     The ID of the player to update.
     * @param player The updated player information.
     * @return The ResponseEntity containing the updated player if successful, or a 404 Not Found status if the player is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") Integer id, @RequestBody Player player) {
        Player updatedPlayer = playerRepository.update(id, player);

        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a player by ID.
     *
     * @param id The ID of the player to delete.
     * @return The ResponseEntity with a no content status if the deletion is successful, or a 404 Not Found status if the player is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Integer id) {
        boolean deleted = playerRepository.deleteById(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

