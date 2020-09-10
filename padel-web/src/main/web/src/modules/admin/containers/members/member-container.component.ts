import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
    selector: 'padel-member-container',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member-container.component.html',
})
export class MemberContainerComponent implements OnInit {
    constructor() {}
    ngOnInit() {}
}
