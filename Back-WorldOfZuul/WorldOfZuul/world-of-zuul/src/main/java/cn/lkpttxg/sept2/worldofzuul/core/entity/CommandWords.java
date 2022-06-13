package cn.lkpttxg.sept2.worldofzuul.core.entity;

import cn.lkpttxg.sept2.worldofzuul.core.enums.CommandWord;

import java.util.HashMap;

/**
 * 该类用于存储游戏中可用的行为指令（go\quit\help。。。）<br>
 * 该类通过存储一个命令词汇字符串数组来定义游戏中所有有效的命令.
 *
 *@author txg
 *@version 创建时间：2021年12月31日 上午11:24:21
 */
public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    /**
     * 构造方法，生成指令组对象.
     */

    public CommandWords() {
        validCommands = new HashMap<>();
        //从枚举类型中获取命令
       for (CommandWord commandWord : CommandWord.values()) {
           if (commandWord != CommandWord.UNKNOWN) {
               validCommands.put(commandWord.toString(), commandWord);
           }
       }
    }

    /**
     * 判断某个输入的指令是否为游戏中可用的行为指令.
     *
     *@param commandString 传入的指令
     * @return 如果是游戏行为指令，返回<code>true</code>,否则返回<code>false</code>
     */
    public boolean isCommand(String commandString) {
        //循环检测
        for (String s : validCommands.keySet()) {
            if (s.equals(commandString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得某个字符串命令对应的 CommandWord 枚举对象.
     *
     *@param word 字符串类型的变量
     * @return 返回其对应的枚举类型
     */
    public CommandWord getCommandWord(String word) {
        if (validCommands.containsKey(word)) {
            return validCommands.get(word);
        }
        return null;
    }

    /**
     * 控制台打印所有的行为指令.
     */

    public void showAll() {
        for (String s : validCommands.keySet()) {
            System.out.println(s + " " + validCommands.get(s).getDescription());
        }
        System.out.println();
    }
}
