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
import {Group, Member} from "@common/models";
import {RouteData} from "@common/services/route-data.service";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'padel-group',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './group.component.html',
})
export class GroupComponent implements OnInit, OnChanges, AfterViewInit {


    levels: string[] = ["P50", "P100", "P200", "P300", "P500", "P750", "P1000"];
    @Output() update = new EventEmitter<Group>();
    @Output() remove = new EventEmitter<Group>();
    groupForm: FormGroup;

    constructor(private toastrService: ToastrService,private routeData:RouteData,private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.groupForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],
            'active': [""],
        });
    }


    addGroup() {
        this.groupForm.reset({id:-1});
    }

    removeGroup() {
        this.groupForm.get('active')?.setValue('N');
        const values = this.groupForm.value;
        this.remove.emit(values);
    }


    onSubmit() {
        const values = this.groupForm.value;

        const keys = Object.keys(values);

        if (this.groupForm.valid) {
            this.update.emit(values);
        } else {
            keys.forEach(key => {
                const ctrl = this.groupForm.controls[key];
                if (!ctrl.valid) {
                    ctrl.markAsTouched();
                    this.toastrService.warning("Niet alle gegevens zijn correct ingevuld", "Leden", {positionClass: 'toast-bottom-full-width'});
                }

            });
        }
    }



    fillFormData(group: Group) {
        this.groupForm.controls.id.setValue(group.id);
        this.groupForm.controls.name.setValue(group.name);
        this.groupForm.controls.active.setValue(group.active);

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



