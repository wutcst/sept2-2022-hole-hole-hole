package cn.lkpttxg.sept2.worldofzuul.workbench.service.player.impl;

import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author TXG
 * @date 2022/6/28$
 */
@Service
public class PlayerServiceImpl {
    @Resource
    private PlayerDao playerDao;
}
