import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-group-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './group-container.component.html',
})
export class GroupContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
