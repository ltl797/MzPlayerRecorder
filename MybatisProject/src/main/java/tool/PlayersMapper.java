package tool;

import java.util.List;
import tool.Players;

public interface PlayersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Players record);

    Players selectByPrimaryKey(Integer id);

    List<Players> selectAll();

    int updateByPrimaryKey(Players record);
}