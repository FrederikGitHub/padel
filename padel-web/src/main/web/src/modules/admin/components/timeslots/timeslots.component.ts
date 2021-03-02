import {
    AfterViewInit,
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    OnChanges,
    OnInit,
    SimpleChanges
} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Group} from "@common/models";
import {RouteData} from "@common/services/route-data.service";

@Component({
    selector: 'padel-timeslot',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './timeslots.component.html',
})
export class TimeSlotComponent implements OnInit, OnChanges, AfterViewInit {


    timeSlotForm: FormGroup;

    constructor(private routeData: RouteData, private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.timeSlotForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],


        });
    }


    fillFormData(group: Group) {
        this.timeSlotForm.controls.id.setValue(group.id);
        this.timeSlotForm.controls.name.setValue(group.name);

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



