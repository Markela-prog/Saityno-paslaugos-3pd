package lt.viko.eif.emarkevicius.restcasino;

import lt.viko.eif.emarkevicius.casino.model.Account;
import lt.viko.eif.emarkevicius.casino.model.Player;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
/**
 * The SampleDataInit class is responsible for initializing sample data for players.
 * It implements the ApplicationRunner interface to execute the data initialization logic on application startup.
 */
@Component
public class SampleDataInit implements ApplicationRunner {

    private final PlayerRepository playerRepository;

    /**
     * Constructs a SampleDataInit object with the provided PlayerRepository.
     *
     * @param playerRepository The PlayerRepository used to save the sample player data.
     */
    public SampleDataInit(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Initializes the sample data by creating and saving sample players.
     *
     * @param args The application arguments (not used in this context).
     */
    @Override
    public void run(ApplicationArguments args) {
        Player player1 = new Player(1, "John Doe", new Account(1, "john@example.com", "password1", 30, 5000, 200));
        playerRepository.save(player1);

        Player player2 = new Player(2, "Jane Smith", new Account(2, "jane@example.com", "password2", 20, 100, 0));
        playerRepository.save(player2);
    }
}
