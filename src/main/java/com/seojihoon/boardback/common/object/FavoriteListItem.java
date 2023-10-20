package com.seojihoon.boardback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.seojihoon.boardback.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteListItem {
    private String email;
    private String nickname;
    private String profileImage;

    public FavoriteListItem(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImageUrl();
    }

    public static List<FavoriteListItem> getList(List<UserEntity> userEntities) {
        List<FavoriteListItem> list = new ArrayList<>();
        for (UserEntity userEntity: userEntities) {
            FavoriteListItem favoriteListItem = new FavoriteListItem(userEntity);
            list.add(favoriteListItem);
        }
        return list;
    }
}
