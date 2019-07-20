import {Component, OnInit} from '@angular/core';
import {TaskService} from "../task.service";
import {Task} from "../task.model";

@Component({
    selector: 'app-tasks-add',
    templateUrl: './tasks-add.component.html',
    styleUrls: ['./tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {

    addTaskValue: string = null;

    constructor(private taskService: TaskService) {}

    ngOnInit() {
    }

    onTaskAdd(event) {
        let task: Task = new Task(event.target.value, this.getTodayAsString(), false);
        this.taskService.addTask(task).subscribe(
            (newTask: Task) => {

                this.addTaskValue = ' ';
                this.taskService.onTaskAdded.emit(newTask);
            }
        )
    }

    getTodayAsString() {
        let today = new Date();
        let day: any = today.getDate();
        let month: any = today.getMonth();
        let year: any = today.getFullYear();

        if (day < 10) {
            day = '0' + day;
        }

        if (month < 10) {
            month = '0' + month;
        }

        return day + '-' + month + '-' + year;
    }
}
