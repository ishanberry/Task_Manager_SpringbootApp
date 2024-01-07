package com.task.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Task;
@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{

}
//  through this interface the crud operation logic fetchng ... crud operation by this perfromed