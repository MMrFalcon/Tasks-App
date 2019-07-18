import {Component, OnInit} from '@angular/core';
import {Task} from '../task.model';

@Component({
    selector: 'app-tasks-list',
    templateUrl: './tasks-list.component.html',
    styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

    tasks: Task[] = [];

    constructor() {
    }

    ngOnInit() {
        this.tasks.push(new Task(1, "task 1", "12-07-2019", true));
        this.tasks.push(new Task(2, "task 2", "14-07-2019", false));
        this.tasks.push(new Task(3, "task 3", "20-07-2019", false));
    }

    getDueDateLabel(task: Task) {
        return task.completed? 'badge-success' : 'badge-primary'
    }

    onTaskChange(event, task) {
        console.log('Task change');
    }
}
