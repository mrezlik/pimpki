package cell.cellcontent;

import cell.CellPaths;

public class Wall implements Content, Obstacle{
    private static final String IMAGE_PATH = CellPaths.WALL.getPath();

    @Override
    public String getImagePath() {
        return IMAGE_PATH;
    }

}
