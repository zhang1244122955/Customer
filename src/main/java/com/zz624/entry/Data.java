package com.zz624.entry;

import java.util.List;

public class Data {

    private Mine mine;
    private List<Friend> friend;
    private List<Group> group;
    public void setMine(Mine mine) {
         this.mine = mine;
     }
     public Mine getMine() {
         return mine;
     }

    public void setFriend(List<Friend> friend) {
         this.friend = friend;
     }
     public List<Friend> getFriend() {
         return friend;
     }

    public void setGroup(List<Group> group) {
         this.group = group;
     }
     public List<Group> getGroup() {
         return group;
     }

}