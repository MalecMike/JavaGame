import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListOfEnemysAndObstacles{
    private List<Obstacles> obstaclesList = new LinkedList<>();
    Obstacles obstacles;
    public ListOfEnemysAndObstacles(){
        addObstacle(new Obstacles(-13,580,12250,30)); // sam dol
        addObstacle(new Obstacles(200,190,800,30)); // gora dlugi
        addObstacle(new Obstacles(585,140,50,50)); // gora krotki
        addObstacle(new Obstacles(270,470,120,30));
        addObstacle(new Obstacles(35,390,120,30));
        addObstacle(new Obstacles(20,270,68,30));
        addObstacle(new Obstacles(800,470,120,30));
        addObstacle(new Obstacles(1035,390,120,30));
        addObstacle(new Obstacles(1120,270,60,30));
        addObstacle(new Obstacles(500,380,196,20));
        addObstacle(new Obstacles(500,400,196,45));
        addObstacle(new Obstacles(500,445,196,45));
        addObstacle(new Obstacles(500,490,196,45));
        addObstacle(new Obstacles(500,535,196,45));
    }
    public void render(Graphics g){
        for(int i = 0;i<obstaclesList.size();i++){
            obstacles = obstaclesList.get(i);
            obstacles.render(g);
        }
    }

    public void addObstacle(Obstacles obstacles){
        obstaclesList.add(obstacles);
    }
    public void removeObstacle(Obstacles obstacles){
        obstaclesList.add(obstacles);
    }
    public List<Obstacles> getObstaclesList() {
        return obstaclesList;
    }
    public void setObstaclesList(List<Obstacles> obstaclesList) {
        this.obstaclesList = obstaclesList;
    }
}