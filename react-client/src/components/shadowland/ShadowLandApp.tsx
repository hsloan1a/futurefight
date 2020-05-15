import React from 'react'

import {Col, Container, Row} from "react-bootstrap";
import LevelList from "./level/LevelList";
import {Level} from "./model/Level";
import axios from "axios";
import {map, uniq, filter} from "underscore"
import LevelListDetail from "./level/LevelListDetail";
import CharacterList from "../character/CharacterList";
import {Character} from "./model/Character";
import {LevelWinDetails} from "./model/LevelWinDetails";

type ShadowLandState = {
    currentLevel: number,
    levelList: number[],
    allLevels: Level[],
    allCharactersList: Character[],
    previouslyWon: LevelWinDetails[],
    selectedLevel: Level
    allCharactersFilteredList: Character[]
}

class ShadowLandApp extends React.Component<any, any> {
    state = {
        currentLevel: 1,
        levelList: [1],
        allLevels: [],
        allCharactersList: [],
        previouslyWon: [],
        selectedLevel: null,
        allCharactersFilteredList: []

    }

    private setLevel = (currentLevel: number) => {
        this.setState({currentLevel, allCharactersFilteredList: [...this.state.allCharactersList]});
    }

    private addLevel = (level: Level) => {
        axios.post(process.env.REACT_APP_APP_BACKEND_BASEURL + 'shadowland/level/', level).then((response) => {
            if (response.status === 201){
                let allLevels: Level[] = [...this.state.allLevels]
                const { data } = response;
                const addedLevel: Level = data;
                allLevels.push(addedLevel)
                this.setState({allLevels})
            }
        })
    }

    private currentSelectedLevelDetail = (level: Level) => {
        const allCharactersFilteredList = filter([...this.state.allCharactersList], (character: Character) =>
            {
                let advantage = level.floor_advantage.toLowerCase();
                return character.affinity.toLowerCase() === level.floor_advantage.toLowerCase()
            })

        // if (this.state.selectedLevel == null || selectedLevel !== this.state.selectedLevel)
        this.setState({allCharactersFilteredList})



    }

    private deleteLevel = (levelId: number) => {
        const deleteUrl = 'shadowland/level/' + String(levelId)
        axios.delete(process.env.REACT_APP_APP_BACKEND_BASEURL + deleteUrl).then((response) => {
            if (response.status === 200){
                let allLevels = [...this.state.allLevels]
                this.setState({allLevels: filter(allLevels, (level:Level) => {return level.id!==levelId})})
            }
        })
    }

    componentDidMount = (): void => {
        axios.get(process.env.REACT_APP_APP_BACKEND_BASEURL + 'shadowland/level/').then((response) => {
            if (response.data) {
                let levelList = uniq(map(response.data, (level: Level) => {return level.level}));
                this.setState({levelList, allLevels: response.data});

            }
        })
        axios.get(process.env.REACT_APP_APP_BACKEND_BASEURL + 'characters/characters').then((response) => {
            if (response.data) {
                let characterList = uniq(map(response.data._embedded.marvelCharacterList, (character: Character) => {return character}));
                this.setState({allCharactersList: characterList, allCharactersFilteredList: characterList});

            }
        })
    }

    render = () => {
        const {allCharactersFilteredList, previouslyWon} = this.state;
        return (
            <Container>
                <Row>
                    <Col sm={4}>
                        <LevelList
                        levelList={this.state.levelList}
                        setLevel={this.setLevel}
                        currentLevel={this.state.currentLevel}
                        />
                    </Col>
                    <Col>
                        <LevelListDetail
                        levelList={this.state.allLevels.length >= 0 ?
                            filter(this.state.allLevels, (level:Level) => level.level === this.state.currentLevel) : []
                        }
                        createLevel={this.addLevel}
                        currentSelectedLevel={this.state.currentLevel}
                        deleteLevel={this.deleteLevel}
                        currentSelectedLevelDetail={this.currentSelectedLevelDetail}
                        />
                    </Col>
                </Row>
                <Row>
                    <Col sm>
                        <CharacterList filteredList={allCharactersFilteredList} title={"All Characters"} />
                    </Col>
                    <Col sm>
                        <CharacterList filteredList={previouslyWon} title={"Characters Previously Used"} />
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default ShadowLandApp;