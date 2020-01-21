package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Game;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

public enum MinesweeperRestClient {

    INSTANCE;

    private HttpClient client;
    private ObjectMapper mapper;
    private static String URI = "http://ec2-18-191-183-190.us-east-2.compute.amazonaws.com:8080/";
    private static final Logger log = Logger.getLogger(MinesweeperRestClient.class);

    MinesweeperRestClient(){
        client = HttpClientBuilder.create().build();
        mapper = new ObjectMapper();
    }

    public Game[] listGames() throws ApiException{
        Game[] games = null;

        try{
            HttpGet request = new HttpGet(URI+"games");
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity httpEntity = response.getEntity();
                games = mapper.readValue(httpEntity.getContent(), Game[].class);
            }else{
                throw new ApiException("fail_getting_games", "An error has occurred getting games", response.getStatusLine().getStatusCode());
            }

        }catch (Exception e){
            log.error("Error getting games", e);
            throw new ApiException("fail_getting_games", "An error has occurred getting games");
        }

        return games;
    }

    public Game getGame(Integer id) throws ApiException{
        Game game = null;

        try{
            HttpGet request = new HttpGet(URI+"games/"+id);
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity httpEntity = response.getEntity();
                game = mapper.readValue(httpEntity.getContent(), Game.class);
            }else{
                throw new ApiException("fail_getting_game", "An error has occurred getting game with id: "+id, response.getStatusLine().getStatusCode());
            }

        }catch (Exception e){
            log.error("Error getting game with id: "+id, e);
            throw new ApiException("fail_getting_game", "An error has occurred getting game with id: "+id);
        }

        return game;
    }

    public Game createGame(Integer rows, Integer cols, Integer mines) throws ApiException{
        Game game = null;

        try{
            HttpPost request = new HttpPost(URI+"game");
            request.setHeader("Content-type", "application/json");
            String jsonGame = "{\"rows\":"+rows+",\"cols\":"+cols+",\"mines\":"+mines+"}";
            StringEntity entity = new StringEntity(jsonGame);
            request.setEntity(entity);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED){
                HttpEntity httpEntity = response.getEntity();
                game = mapper.readValue(httpEntity.getContent(), Game.class);
            }else{
                throw new ApiException("fail_creating_game", "An error has occurred creating new game", response.getStatusLine().getStatusCode());
            }

        }catch (Exception e){
            log.error("Error creating new game", e);
            throw new ApiException("fail_creating_game", "An error has occurred creating new game");
        }

        return game;
    }

    public Game revealCell(Integer id, Integer row, Integer col) throws ApiException{
        Game game = null;

        try{
            HttpPost request = new HttpPost(URI+"games/"+id+"/reveal");
            request.setHeader("Content-type", "application/json");
            String jsonGame = "{\"row\":"+row+",\"col\":"+col+"}";
            StringEntity entity = new StringEntity(jsonGame);
            request.setEntity(entity);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity httpEntity = response.getEntity();
                game = mapper.readValue(httpEntity.getContent(), Game.class);
            }else{
                throw new ApiException("fail_revealing_cell", "An error has occurred revealing cell", response.getStatusLine().getStatusCode());
            }

        }catch (Exception e){
            log.error("Error revealing cell", e);
            throw new ApiException("fail_revealing_cell", "An error has occurred revealing cell");
        }

        return game;
    }

    public Game flagCell(Integer id, Integer row, Integer col) throws ApiException{
        Game game = null;

        try{
            HttpPost request = new HttpPost(URI+"games/"+id+"/flag");
            request.setHeader("Content-type", "application/json");
            String jsonGame = "{\"row\":"+row+",\"col\":"+col+"}";
            StringEntity entity = new StringEntity(jsonGame);
            request.setEntity(entity);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity httpEntity = response.getEntity();
                game = mapper.readValue(httpEntity.getContent(), Game.class);
            }else{
                throw new ApiException("fail_creating_game", "An error has occurred flagging cell", response.getStatusLine().getStatusCode());
            }

        }catch (Exception e){
            log.error("Error flagging cell", e);
            throw new ApiException("fail_flagging_cell", "An error has occurred flagging cell");
        }

        return game;
    }
}
