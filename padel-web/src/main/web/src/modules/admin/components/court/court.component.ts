import {
    AfterViewInit,
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component, EventEmitter,
    OnChanges,
    OnInit, Output,
    SimpleChanges
} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Court, Group, Member} from "@common/models";
import {RouteData} from "@common/services/route-data.service";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'padel-court',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court.component.html',
})
export class CourtComponent implements OnInit, OnChanges, AfterViewInit {

    @Output() update = new EventEmitter<Court>();

    courtForm: FormGroup;

    constructor(private toastrService: ToastrService,private routeData:RouteData,private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.courtForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],
        });
    }


    addCourt() {
        this.courtForm.reset({id:-1});
    }

    removeCourt() {
        this.courtForm.get('active')?.setValue('N');
        this.onSubmit();
    }


    onSubmit() {
        const values = this.courtForm.value;

        const keys = Object.keys(values);

        if (this.courtForm.valid) {
            this.update.emit(values);
        } else {
            keys.forEach(key => {
                const ctrl = this.courtForm.controls[key];
                if (!ctrl.valid) {
                    ctrl.markAsTouched();
                    this.toastrService.warning("Niet alle gegevens zijn correct ingevuld", "Leden", {positionClass: 'toast-bottom-full-width'});
                }

            });
        }
    }




    fillFormData(court: Court) {
        this.courtForm.controls.id.setValue(court.id);
        this.courtForm.controls.name.setValue(court.name);

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



