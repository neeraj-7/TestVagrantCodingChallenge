import com.fasterxml.jackson.databind.ObjectMapper;
import ipl.Player;
import ipl.Team;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCases {

    ObjectMapper mapper;
    BufferedReader br;
    FileReader fileReader;
    Team team;


    private static final String JSON_FILE_PATH = "src/test/resources/rcb.json";


    @BeforeClass
    public void getTestData(){

        mapper = new ObjectMapper();
        try {
            fileReader = new FileReader(JSON_FILE_PATH);
            br = new BufferedReader(fileReader);
            team = mapper.readValue(br,Team.class);

        }catch (FileNotFoundException e){
           e.printStackTrace();
        }  catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test(description = "Verify that the team has only 4 foreign players")
    public void checkNoOfForeignPlayers(){
        List<String> foreignPlayers = new ArrayList<>();
        List<Player> players= team.getPlayer();

        for(Player player : players){
            //check country of each player if he doesn't belong to India, add him to the list
            if(!player.getCountry().equalsIgnoreCase("India")){
                foreignPlayers.add(player.getCountry());
            }
        }

        Assert.assertEquals(foreignPlayers.size(),4,"No of foreign player is not equal to 4");
    }

    @Test(description = "Verify that there is at least one wicket keeper")
    public void verifyAtLeastOneWicketKeeper(){
        List<String> wicketKeepers = new ArrayList<>();
        List<Player> players= team.getPlayer();

        for(Player player : players){
            //check role of each player if he is wicket keeper, add him to the wicketKeepers list
                if(player.getRole().equalsIgnoreCase("Wicket-keeper")){
                    wicketKeepers.add(player.getRole());
                }
            }

        Assert.assertTrue(wicketKeepers.size() >= 1,"there is no wicket keeper in the list");
        }

}
