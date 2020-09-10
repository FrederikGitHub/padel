import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-poule-admin',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule-admin.component.html',

})
export class PouleAdminComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
