import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-poule-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule-container.component.html',
})
export class PouleContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
