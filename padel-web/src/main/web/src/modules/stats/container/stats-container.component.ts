import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-stats-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './stats-container.component.html',

})
export class StatsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
