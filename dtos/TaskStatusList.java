package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgsits.cse.dis.user.model.UserTasks;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskStatusList {
    private List<UserTasks> inProgressList;
    private List<UserTasks> completedList;
    private List<UserTasks> onHoldList;

    public List<UserTasks> getInProgressList() {
        return inProgressList;
    }

    public void setInProgressList(List<UserTasks> inProgressList) {
        this.inProgressList = inProgressList;
    }

    public List<UserTasks> getCompletedList() {
        return completedList;
    }

    public void setCompletedList(List<UserTasks> completedList) {
        this.completedList = completedList;
    }

    public List<UserTasks> getOnHoldList() {
        return onHoldList;
    }

    public void setOnHoldList(List<UserTasks> onHoldList) {
        this.onHoldList = onHoldList;
    }
}
