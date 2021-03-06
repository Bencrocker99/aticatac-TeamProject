package com.aticatac.database;

import com.aticatac.common.mappers.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class DBinterface {
  private final Logger logger;

  public DBinterface() {
    logger = Logger.getLogger(getClass());
  }

  public Optional<Player> getPlayer(String id) {
    stats(id);
    SqlSession session = SessionFactory.getSession();
    Player player = session.selectOne("Player.getByUsername", id);
    session.close();
    if (player != null) {
      return Optional.of(player);
    } else {
      return Optional.empty();
    }
  }

  public void stats(String id) {
    SqlSession session = SessionFactory.getSession();
    Player player = session.selectOne("Player.getByUsername", id);
    session.update("Player.updateStats", player);
    SessionFactory.returnSession(session);
  }

  public HashMap<String, Player> getLobby(ArrayList<String> names) {
    SqlSession session = SessionFactory.getSession();
    HashMap<String, Player> players = new HashMap<>();
    for (String name : names) {
      Player player = session.selectOne("Player.getByUsername", name);
      players.put(name, player);
    }
    SessionFactory.returnSession(session);
    return players;
  }

  public List<Player> getLeaderboard() {
    SqlSession session = SessionFactory.getSession();
    List<Player> leaderboard = session.selectList("Player.getLeaderboard");
    SessionFactory.returnSession(session);
    return leaderboard;
  }

  public Player addPlayer(final Player player) throws PersistenceException {
    SqlSession session = SessionFactory.getSession();
    session.insert("Player.insert", player);
    Player player1 = new Player();
    this.logger.info(player);
    session.selectOne("Player.getByUsername", player.username);
    this.logger.info(player1);
    session.commit();
    SessionFactory.returnSession(session);
    return player1;
  }
}
