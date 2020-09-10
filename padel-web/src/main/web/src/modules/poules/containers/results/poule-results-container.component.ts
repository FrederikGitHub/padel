import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-poule-results-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule-results-container.component.html',

})
export class PouleResultsContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
