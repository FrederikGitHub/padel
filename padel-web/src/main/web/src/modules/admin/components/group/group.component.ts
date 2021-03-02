import {
    AfterViewInit,
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    OnChanges,
    OnInit,
    SimpleChanges
} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Group, Member} from "@common/models";
import {RouteData} from "@common/services/route-data.service";

@Component({
    selector: 'padel-group',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './group.component.html',
})
export class GroupComponent implements OnInit, OnChanges, AfterViewInit {


    levels: string[] = ["P50", "P100", "P200", "P300", "P500", "P750", "P1000"];

    groupForm: FormGroup;

    constructor(private routeData:RouteData,private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.groupForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],
            'vtvLevel': ["", Validators.required],

        });
    }









    fillFormData(group: Group) {
        this.groupForm.controls.id.setValue(group.id);
        this.groupForm.controls.name.setValue(group.name);
        this.groupForm.controls.vtvLevel.setValue(group.vtvLevel);

    }

    ngOnInit(): void {

        this.fillFormData(this.routeData.storage);
    }

    ngAfterViewInit() {
        this.cd.detectChanges();
    }

    ngOnChanges(changes: SimpleChanges): void {


    }


}



