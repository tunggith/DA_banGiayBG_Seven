package sanPham;

import sanPham.ChatLieu;
import java.util.List;

public interface ChatLieuService {

    List<ChatLieu> getChatLieu();

    public boolean add(ChatLieu cl);
}
