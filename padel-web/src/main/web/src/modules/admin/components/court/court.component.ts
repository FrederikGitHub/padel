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
    selector: 'padel-court',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court.component.html',
})
export class CourtComponent implements OnInit, OnChanges, AfterViewInit {


    courtForm: FormGroup;

    constructor(private routeData:RouteData,private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.courtForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],


        });
    }









    fillFormData(group: Group) {
        this.courtForm.controls.id.setValue(group.id);
        this.courtForm.controls.name.setValue(group.name);
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



