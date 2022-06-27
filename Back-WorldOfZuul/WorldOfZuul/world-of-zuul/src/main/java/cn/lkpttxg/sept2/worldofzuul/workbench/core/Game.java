package cn.lkpttxg.sept2.worldofzuul.workbench.core;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.map.GameMap;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/27$
 */
@Component
@Data
public class Game {
    private GameMap gameMap;
    private HashMap<String,Player> players;
    @Resource
    private RedisTemplate<String,byte[]> redisTemplate;

    public Game(){
        initialGame();
    }

    private void initialGame() {
        gameMap = new GameMap();
        players = new HashMap<>();
    }

    /**
     * 注入在线玩家
     * @param player
     * @return
     */
    public Player addPlayer(Player player){
        players.put(player.getId(),player);
        player.setCurrentRoom(gameMap.getInitRoom());
        return player;
    }

    /**
     * 移除在线玩家
     * @param player
     * @return
     */
    public Player removePlayer(Player player){
        players.remove(player.getId());
        return player;
    }

}