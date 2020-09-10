import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-poule-admin-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule-admin-container.component.html',

})
export class PouleAdminContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
