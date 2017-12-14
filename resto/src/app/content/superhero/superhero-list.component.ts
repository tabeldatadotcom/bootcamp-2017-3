import { Component } from "@angular/core";

@Component({
    selector: 'app-superhero-list',
    templateUrl: './superhero-list.component.html'
})
export class SuperheroListComponent {
    superheroes: Array<{ nama: string, ability: string }> = [
        { nama: "Superman", ability: "Laser" },
        { nama: "Wonder Women", ability: "Ngaso" },
        { nama: "Iron man", ability: "ngudud" }
    ];

    addAnItem(value: {name: string, ability: string}){
         this.superheroes.push({nama: value.name, ability: value.ability});
    }

    hapusData(value:number){
        this.superheroes.splice(value, 1);
    }

}