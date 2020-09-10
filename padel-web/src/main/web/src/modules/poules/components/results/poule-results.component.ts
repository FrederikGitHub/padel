import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-poule-results',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule-results.component.html',

})
export class PouleResultsComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
