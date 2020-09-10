import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-stats',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './stats.component.html',

})
export class StatsComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
