import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-court-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-container.component.html',
})
export class CourtContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
